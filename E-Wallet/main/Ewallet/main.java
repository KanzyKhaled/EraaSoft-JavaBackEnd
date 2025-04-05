package Ewallet;


import Ewallet.service.ApplicationService;
import Ewallet.service.impl.ApplicationServiceImpl;


public class main {
    public static void main(String[] args) throws Exception {

        ApplicationService applicationService = new ApplicationServiceImpl();
        applicationService.start();

    }
}
