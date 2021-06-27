package com.game.core;


import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import io.cucumber.plugin.event.TestStepStarted;

public class StartExecution extends Base implements ConcurrentEventListener  {

	

    public EventHandler<TestStepStarted> stepHandler = new EventHandler<TestStepStarted>() {
        @Override
        public void receive(TestStepStarted event) {
            handleTestStepStarted(event);
        }

    };
   
    private EventHandler<TestRunStarted> beforeAll = event -> {
    	SimpleDateFormat report_name = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		reportTime=report_name.format(date);
		System.out.println("Initializing Driver.........");
		setUp();
		
	};
	
	private EventHandler<TestRunFinished> afterAll = event -> {
		tearDown();
		System.out.println("Server stoped...");
		
	};


    @Override
    public void setEventPublisher(EventPublisher publisher) {
        
        publisher.registerHandlerFor(TestRunStarted.class, beforeAll);
        publisher.registerHandlerFor(TestStepStarted.class, stepHandler);
        publisher.registerHandlerFor(TestRunFinished.class, afterAll);
    }

    private void handleTestStepStarted(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep)event.getTestStep();
            stepName = testStep.getStep().getText();
        }


    }
}

