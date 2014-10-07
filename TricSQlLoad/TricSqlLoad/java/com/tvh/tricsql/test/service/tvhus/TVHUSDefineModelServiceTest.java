package com.tvh.tricsql.test.service.tvhus;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tvh.blcore.tricsql.beans.IGenericModel;
import com.tvh.blcore.tricsql.beans.IPage;
import com.tvh.blcore.tricsql.beans.IPart;
import com.tvh.blcore.tricsql.beans.ISection;
import com.tvh.blcore.tricsql.beans.Make;
import com.tvh.blcore.tricsql.beans.Model;
import com.tvh.blcore.tricsql.beans.ProviderType;
import com.tvh.blcore.tricsql.beans.configuration.IFmiTab;
import com.tvh.blcore.tricsql.beans.search.ControlPanel;
import com.tvh.blcore.tricsql.beans.search.IControlPanel;
import com.tvh.blcore.tricsql.beans.search.IEngine;
import com.tvh.blcore.tricsql.beans.search.IMast;
import com.tvh.blcore.tricsql.beans.search.ITransmission;
import com.tvh.blcore.tricsql.beans.search.ModelSearchSpecHolder;
import com.tvh.blcore.tricsql.beans.search.ModelSearchSpecInfo;
import com.tvh.blcore.tricsql.beans.search.SearchPartBean;
import com.tvh.blcore.tricsql.service.extern.tvhus.TVHUSCatalogService;
import com.tvh.blcore.tricsql.service.extern.tvhus.TVHUSDefineModelService;
import com.tvh.util.STR;
import com.tvh.website.tricsql.panel.config.LayoutConfigurationHelper;

@ContextConfiguration(locations="tvhus-service-client-config.xml")
public class TVHUSDefineModelServiceTest extends AbstractJUnit4SpringContextTests {

	protected static final Logger log = LoggerFactory.getLogger(TVHUSDefineModelServiceTest.class);  
	
	@Autowired private TVHUSDefineModelService tvhUSDefineModelService;
	
	@Autowired private TVHUSCatalogService tvhUSCatalogService;
	
	@Before
	public void beforeMethod() {
		
		boolean webServiceAvailable = false;
		
		  try {
			
			URL url = new URL("http://localhost:8080/TricSQL/services/TVHUSDefineModel?wsdl");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestProperty("Connection", "close");
			connection.setConnectTimeout(10000); // Timeout 10 seconds
			connection.connect();
			// If the web service is available
			if (connection.getResponseCode() == 200) {
				webServiceAvailable = true;
			}
		} catch (Exception e) {
			//failed to connect to service
		}
		org.junit.Assume.assumeTrue(webServiceAvailable);
	   
	 }
	
	@Test
	public void testMakes() {
		
		Set<Make> makes =  tvhUSDefineModelService.getMakes();
		
		Assert.assertNotNull(makes);
		
		Make komatsu = new Make(ProviderType.GENERIC);
		komatsu.setDescription("KOMATSU");
		
		Assert.assertTrue(makes.contains(komatsu)); 
	}
	
	@Test
	public void testModelsForMakes() {
		
		Make komatsu = new Make(ProviderType.GENERIC);
		komatsu.setDescription("KOMATSU");
		
		Set<IGenericModel> models =  tvhUSDefineModelService.getModelsForMake(komatsu.getDescription(), null);
		
		Assert.assertNotNull(models);
		
		boolean modelPresent = false;
		for (IGenericModel model : models) {
			if ("FG10HC-14".equals(model.getDescription())) {
				modelPresent = true;
				break;
			}
		}
		
		Assert.assertTrue(modelPresent); 
	}
	
	@Test
	public void testModelSpecifications() {
		
		Make komatsu = new Make(ProviderType.GENERIC);
		komatsu.setDescription("KOMATSU");
		
		IGenericModel fg10HC14Model = new Model();
		fg10HC14Model.setDescription("FG10HC-14");
		
		List<IGenericModel> models =  tvhUSDefineModelService.getAllModelsForNameAndMake(fg10HC14Model.getDescription(), "KOMATSU", null);
		
		Assert.assertNotNull(models);
		
		boolean allValidModels = true;
		for (IGenericModel model : models) {
			if (!"FG10HC-14".equals(model.getDescription())) {
				allValidModels = false;
				break;
			}
		}
		
		List<ModelSearchSpecInfo> modelSearchInfoList = tvhUSDefineModelService.getModelSpecifications(komatsu.getDescription(), models.get(0));
		
		ModelSearchSpecHolder specHolder = buildSpecsHolder(modelSearchInfoList);
		
		SearchPartBean searchBean = new SearchPartBean();
		searchBean.setTransmission(specHolder.getTransmissionSpecs().iterator().next());
		searchBean.setModel(models.get(0));
		//load table of contents
		
		List<IFmiTab> fmiTabs = tvhUSCatalogService.findBookFmiTabs(searchBean);
		
		//load parts for FMI tab
		log.info(" Get parts for fmi tab: "+ fmiTabs.get(0).getDescription());
		List<IPart> fmiTabParts =  tvhUSCatalogService.findPartsForFmiTab(fmiTabs.get(0), searchBean);
		
		List<ISection> sections = tvhUSCatalogService.findBookSections(searchBean);
		IPage page = (IPage) sections.get(0).getChildrenList().get(0);
		log.info(" Get parts for page: "+ page.getPageName());
		
		//load parts for page
		List<IPart> pageParts = tvhUSCatalogService.findPartsForPage( page.getBookId(), page.getId(), page.getImageFile(), searchBean);
		
		Assert.assertTrue(allValidModels);
	}
	
	protected ModelSearchSpecHolder buildSpecsHolder(final List<ModelSearchSpecInfo> modelSearchInfoList) {
		
		Set<IEngine> engineSpecs = new HashSet<>(modelSearchInfoList.size());
        Set<ITransmission> transmissionSpecs = new HashSet<>(modelSearchInfoList.size());

        Set<IMast> mastSpecs = new HashSet<>(modelSearchInfoList.size());
        Set<IControlPanel> controlPanelSpecs = new HashSet<>(modelSearchInfoList.size());
		
		ModelSearchSpecHolder specsHolder = new ModelSearchSpecHolder();

		for (ModelSearchSpecInfo specInfo : modelSearchInfoList) {

        	//engine specs
			if ( !STR.isEmpty(specInfo.getEngineMake()) ||
					 !STR.isEmpty(specInfo.getEngineModel()) ||
					 !STR.isEmpty(specInfo.getEngineSerialFrom()) ||
					 !STR.isEmpty(specInfo.getEngineSerialTo()) ||
					 !STR.isEmpty(specInfo.getFuelType()) )  {
			
				engineSpecs.add(LayoutConfigurationHelper.buidEngineInfo(specInfo));
			}
			
			//transmission specs
			if ( !STR.isEmpty(specInfo.getTransmissionMake() ) ||
					!STR.isEmpty(specInfo.getTransmissionModel()) ||
					!STR.isEmpty(specInfo.getTransmissionType())  ) {
				
				transmissionSpecs.add(LayoutConfigurationHelper.buidTransmissionInfo(specInfo));
			}
			
			
			//mast specs
			if ( !STR.isEmpty(specInfo.getMastMake())  ||
					 !STR.isEmpty(specInfo.getMastModel()) ||
					!STR.isEmpty(specInfo.getMastDescription()) ) {
				
				mastSpecs.add(LayoutConfigurationHelper.buidMastInfo(specInfo));
			}
			
			
			IControlPanel controlPanel = new ControlPanel();
			if ( !STR.isEmpty(specInfo.getControlPanel()) ||
					!STR.isEmpty(specInfo.getVoltage()) && !"0".equals(specInfo.getVoltage()) ) {
				
				controlPanel.setDescription(specInfo.getControlPanel());
				controlPanel.setVoltage(specInfo.getVoltage());
				controlPanelSpecs.add(controlPanel);
			}
		}

        specsHolder.setEngineSpecs(engineSpecs);
        specsHolder.setTransmissionSpecs(transmissionSpecs);
        specsHolder.setMastSpecs(mastSpecs);
        specsHolder.setControlPanelSpecs(controlPanelSpecs);

        return specsHolder;
	}
}
