package com.boot.dashbaord;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordsDashboard {

	private String sname;
	private String contactNo;
	private String classMode;
	private String course;
	private String enqStatus;

//	@CreationTimestamp
//	@Column(updatable = false)
//	@Temporal(TemporalType.DATE)
//	private Date enqDate;

}
