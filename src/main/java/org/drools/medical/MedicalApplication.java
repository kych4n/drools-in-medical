package org.drools.medical;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.opencsv.exceptions.CsvException;

import common.CSVReader;

public class MedicalApplication {

	public static void main(String[] args) throws CsvException, IOException {
		KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
		execute( kc );
	}

	public static void execute( KieContainer kc ) throws CsvException, IOException {
		CSVReader csvReader = new CSVReader();
		List<Patient> patients = csvReader.getPatients();

		StatelessKieSession ksession = kc.newStatelessKieSession( "MedicalKS");
		ksession.execute(patients);

	}

}
