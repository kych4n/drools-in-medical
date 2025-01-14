package common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.drools.medical.Patient;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class CSVReader {

	private String filePath = "src/main/resources/org/drools/medical/data/test.csv";
	private com.opencsv.CSVReader csvReader;
	private int indexIdx;
	private int sbpIdx;
	private int respirationRateIdx;
	private int complaintsIdx;

	public CSVReader() throws IOException, CsvValidationException {
		this.csvReader = new com.opencsv.CSVReader(new FileReader(filePath));
		List<String> header = Arrays.asList(csvReader.readNext());
		this.indexIdx = header.indexOf("index");
		this.sbpIdx = header.indexOf("triage_sbp");
		this.respirationRateIdx = header.indexOf("triage_resprate");
		this.complaintsIdx = header.indexOf("chiefcomplaint");
	}

	public List<Patient> getPatients() throws IOException, CsvException {
		List<String[]> patients = this.csvReader.readAll();

		return patients.stream().map(patient -> new Patient(Long.parseLong(patient[indexIdx]),
			Double.parseDouble(patient[sbpIdx]),
			Double.parseDouble(patient[respirationRateIdx]),
			patient[complaintsIdx])).collect(Collectors.toList());
	}

}
