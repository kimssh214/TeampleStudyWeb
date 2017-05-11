package kr.co.teamplestudyweb.web.controller.rest.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import kr.co.teamplestudyweb.web.controller.rest.CommonRestController;
import kr.co.teamplestudyweb.web.controller.rest.login.LoginRestController;

@RestController
public class MainRestController extends CommonRestController {
	private static final Logger log = LoggerFactory.getLogger(MainRestController.class);
}
