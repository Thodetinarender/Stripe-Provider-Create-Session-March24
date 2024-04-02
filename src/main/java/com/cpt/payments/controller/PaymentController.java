package com.cpt.payments.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.constants.ControllerEndpoints;
import com.cpt.payments.pojo.StripeProviderRequest;
import com.cpt.payments.pojo.StripeProviderResponse;
import com.cpt.payments.util.LogMessage;

@RestController
@RequestMapping(ControllerEndpoints.PAYMENT_BASE_URI)
public class PaymentController {
	
	private static final Logger LOGGER = LogManager.getLogger(PaymentController.class);

	
	@PostMapping(ControllerEndpoints.PROCESS_PAYMENT)
	public ResponseEntity<StripeProviderResponse> initiatePayment(@RequestBody StripeProviderRequest stripeProviderRequest) {
		LogMessage.setLogMessagePrefix(ControllerEndpoints.PROCESS_PAYMENT);

		LogMessage.log(LOGGER, " processing stripe payment with request ::: " + stripeProviderRequest);
		
		//TODO This hard coded is only for testing . replace this with actual String;
		StripeProviderResponse response = StripeProviderResponse.builder()
				.paymentId("stripe-provider-paymentid")
				.redirectUrl("http://redirect.stripe.com")
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
