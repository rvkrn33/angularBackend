package org.sambasoft;

import org.sambasoft.entities.FlatDtls;
import org.sambasoft.entities.Menu;
import org.sambasoft.entities.TransactionsDtls;
import org.sambasoft.entities.User;
import org.sambasoft.repositories.FlatDtlsRepository;
import org.sambasoft.repositories.MenuRepository;
import org.sambasoft.repositories.TransactionsDtlsRepository;
import org.sambasoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class CrudBackendApplication  implements CommandLineRunner{

	private static final Logger LOGGER = LogManager.getLogger(CrudBackendApplication.class);
	 
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FlatDtlsRepository flatDtlsRepository;
	
	@Autowired
	private TransactionsDtlsRepository tranDtlsRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	
	 @Autowired
	 DataSource dataSource;
	 
	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);

		LOGGER.info("Ravikiran ....................");
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("u1","pass1","Admin"));
		userRepository.save(new User("u2","pass2","Other"));
		userRepository.save(new User("u3","pass3","User"));
		
		userRepository.save(new User("user11","123","Admin"));
		userRepository.save(new User("abc","12542","Other"));
		userRepository.save(new User("xyz","3333","User"));
		
		LOGGER.info("User Created >>>");
		
		flatDtlsRepository.save(new FlatDtls("F101", "1 bhk", "Ravi", "01-Apr-2020", 7620770569L,"F", "Yes","150000",200000));
		flatDtlsRepository.save(new FlatDtls("F220", "2 bhk", "Ravikiran", "30-Mar-2020", 7620770579L,"A", "No","0",200000));
		flatDtlsRepository.save(new FlatDtls("F310", "1 bhk", "Amit", "01-Apr-2020", 7620770569L,"C", "Yes","150000",200000));
		flatDtlsRepository.save(new FlatDtls("F900", "2 bhk", "Rajesh", "30-Mar-2020", 7620770579L,"D", "No","0",200000));
		flatDtlsRepository.save(new FlatDtls("F100", "1 bhk", "Amit", "01-Apr-2020", 7620770569L,"M", "Yes","150000",200000));
		
		LOGGER.info("Flats inserted >>>");
		
		tranDtlsRepository.save(new TransactionsDtls("F-110","Apr" , 2020,  "05-May-2020", 1000L, "ok", "ok", "Light"));
		tranDtlsRepository.save(new TransactionsDtls("A-220","Jun" , 2020,  "15-Jun-2020", 2000L, "ok", "ok", "Flat"));
		tranDtlsRepository.save(new TransactionsDtls("C-120","Mar" , 2020,  "08-Mar-2020", 100L, "ok", "ok", "Maintenance"));
		
		tranDtlsRepository.save(new TransactionsDtls("D-110","Jan" , 2020,  "05-May-2020", 1000L, "ok", "ok", "Light"));
		tranDtlsRepository.save(new TransactionsDtls("M-220","Apr" , 2020,  "15-Jun-2020", 2000L, "ok", "ok", "Flat"));
		tranDtlsRepository.save(new TransactionsDtls("C-120","Feb" , 2020,  "08-Mar-2020", 100L, "ok", "ok", "Maintenance"));
		tranDtlsRepository.save(new TransactionsDtls("D-110","Aug" , 2020,  "05-May-2020", 1000L, "ok", "ok", "Light"));
		tranDtlsRepository.save(new TransactionsDtls("E-220","Dec" , 2020,  "15-Jun-2020", 2000L, "ok", "ok", "Flat"));
		tranDtlsRepository.save(new TransactionsDtls("F-120","Apr" , 2020,  "08-Mar-2020", 100L, "ok", "ok", "Maintenance"));
		tranDtlsRepository.save(new TransactionsDtls("F-110","Apr" , 2020,  "05-May-2020", 1000L, "ok", "ok", "Light"));
		tranDtlsRepository.save(new TransactionsDtls("A-220","Oct" , 2020,  "15-Jun-2020", 2000L, "ok", "ok", "Flat"));
		tranDtlsRepository.save(new TransactionsDtls("F-120","Nov" , 2020,  "08-Mar-2020", 100L, "ok", "ok", "Maintenance"));
	
		LOGGER.info("Transactions successfully done >>>");
		
		menuRepository.save(new Menu("Users", true, true, true, true));
		menuRepository.save(new Menu("Falts", true, true, true, false));
		menuRepository.save(new Menu("Menu", true, false, false, false));
		
		LOGGER.info("menuRepository saved >>>");
		//showTables();
	}
	
	public void showTables() throws Exception {
		
		LOGGER.info("Tables ***************************************************************");
		
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE" });
        while (tables.next()) {
            String tableName=tables.getString("TABLE_NAME");
            System.out.println(tableName);
			/*
			 * ResultSet columns = metaData.getColumns(null, null, tableName, "%"); while
			 * (columns.next()) { String columnName=columns.getString("COLUMN_NAME");
			 * System.out.println("\t" + columnName); }
			 */
        }
    }
}
