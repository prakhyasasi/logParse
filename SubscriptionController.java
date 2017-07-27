package au.com.logsearch;

import java.io.IOException;
import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import au.com.logsearch.LogParseManagerImpl;

@RestController
public class SubscriptionController {

	private static final Logger log = LoggerFactory.getLogger(LogSearchController.class);
	
	@Autowired
    LogParseManagerImpl logManagerImpl;

	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public String subscibe(HttpServletRequest request) throws IOException {

		String truncatedOrderDetails ;
		try {
			// TO-DO need to implement this method to read from the file/request
			String orderDetails = getOrderDetails(request);
			truncatedOrderDetails = logManagerImpl.truncate(orderDetails, 250);
			log.info("Final string is.."+truncatedOrderDetails);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			log.error(e.getMessage());
		}

		return truncatedOrderDetails;

	}

}
