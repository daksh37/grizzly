package com.cts.grizzlystoreadminweb.service;

import com.cts.grizzlystoreadminweb.bean.Vendors;
import com.cts.grizzlystoreadminweb.dao.AddVendorDAO;
import com.cts.grizzlystoreadminweb.dao.AddVendorDAOImpl;

public class AddVendorServiceImpl implements AddVendorService {
		private static AddVendorServiceImpl addVendorServiceImpl;
		private AddVendorDAO dao = AddVendorDAOImpl.getInstance();
		public static AddVendorService getInstance(){
			if(addVendorServiceImpl==null)
			{
				addVendorServiceImpl = new AddVendorServiceImpl();
				return addVendorServiceImpl;
			}
			else
				return addVendorServiceImpl;
		}
		
		public String getVendors() {
			// TODO Auto-generated method stub
			return dao.getVendors();
		}
		
		public String insertVendros(Vendors vendors) {
			// TODO Auto-generated method stub
			return dao.insertVendros(vendors);
		}
}
