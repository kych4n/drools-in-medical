package org.drools.medical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {

	private Long index;	// 입원 기록 ID
	private int sbp;	// 수축기 혈압
	private int respirationRate;	// 호흡률
	private Set<String> complaints;	// 불편 사항, 호소 증상

	@Builder
	public Patient(Long index, int sbp, int respirationRate, String complaints) {
		this.index = index;
		this.sbp = sbp;
		this.respirationRate = respirationRate;
		this.complaints = new HashSet<>(Arrays.asList(complaints.split(", ")));

	}

}
