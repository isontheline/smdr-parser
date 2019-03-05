package io.isontheline.smdr;

import java.util.ArrayList;

import org.junit.Test;

public class SMDRParserTest {
	@Test
	public void launchTest() throws Exception {
		SMDRParser parser = new SMDRParser();

		ArrayList<String> smdrRecords = new ArrayList<String>();
		smdrRecords.add(" 03/05 13:14:13             9999         9999999999           00000                                        001   98029                                   C0099410 A                                            ");
		smdrRecords.add("+03/05 13:15:09  0000:00:21         0000 9999                        9907                                  001   9999999999           9999               A0097399 A                                            ");
		smdrRecords.add("-03/05 13:38:35  0000:06:59 9999         9999999999           00000A                                       001   88029                                   A0099648 A                                            ");
		smdrRecords.add("%03/05 13:52:06  0000:00:48         0000 9999                        9908                                  001   9999999999           9999               C0093799 A                                            ");
		smdrRecords.add(" 03/05 15:41:05  0000:00:07 9999         9999999999           00000A                                       001   98029                                   C0093699 A                                            ");
		smdrRecords.add(" 03/05 15:42:46  0000:00:06         **** 9999                        9999                                  001   9999999999           9999               E0093599 A                                            ");
		smdrRecords.add(" 03/05 15:42:52  0000:00:05         0007 9999                        9999                                  001   9999999999           9999               C0093299 A                                            ");
		
		boolean extendedDigitLengthSMDRRecordFields = true;
		
		for(String smdrRecord : smdrRecords) {
			SMDRRecord record = parser.parse(smdrRecord, extendedDigitLengthSMDRRecordFields);
			
			System.out.println("Long Call        : " + record.getLongCall());
			System.out.println("Date             : " + record.getDate());
			System.out.println("Start Time       : " + record.getStartTime());
			System.out.println("Duration of Call : " + record.getDurationOfCall());
			System.out.println("Calling Party    : " + record.getCallingParty());
			System.out.println("Time to Answer   : " + record.getTimeToAnswer());
			System.out.println("Digits Dialed    : " + record.getDigitsDialedOnTheTrunk());
			
			System.out.println("");
		}
	}
}
