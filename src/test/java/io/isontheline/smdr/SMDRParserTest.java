package io.isontheline.smdr;

import java.util.ArrayList;

import org.junit.Test;

public class SMDRParserTest {
	@Test
	public void launchTest() throws Exception {
		SMDRParser parser = new SMDRParser();

		ArrayList<String> smdrRecords = new ArrayList<String>();
		smdrRecords.add(" 03/05 13:14:13             9999         9999999999           00000                                        001   99029                                   C0099410 A                                            ");
		smdrRecords.add("+03/05 13:15:09  0000:00:21         0000 9999                        9907                                  001   9999999999           9999               A0097399 A                                            ");
		smdrRecords.add("-03/05 13:38:35  0000:06:59 9999         9999999999           00000A                                       001   89029                                   A0099648 A                                            ");
		smdrRecords.add("%03/05 13:52:06  0000:00:48         0000 9999                        9908                                  001   9999999999           9999               C0093799 A                                            ");
		smdrRecords.add(" 03/05 15:41:05  0000:00:07 9999         9999999999           00000A                                       001   99029                                   C0093699 A                                            ");
		smdrRecords.add(" 03/05 15:42:46  0000:00:06         **** 9999                        9999                                  001   9999999999           9999               E0093599 A                                            ");
		smdrRecords.add(" 03/05 15:42:52  0000:00:05         0007 9999                        9999                                  001   9999999999           9999               C0093299 A                                            ");
		
		// Call received from 9999999999 to 9000 and then transfered to 9025 :
		smdrRecords.add(" 03/05 16:47:52  0000:00:43         0007 9000                        9000           T 9025                 001   9999999999           9000               C0097299 A                                            ");
		
		// Call received from 9999999999 to 9025 :
		smdrRecords.add(" 03/05 17:16:34  0000:00:05         0002 9025                        9025                                  001   9999999999           9025               C0090299 A                                            ");
		
		// Call emitted from 9025 to 9999999999 :
		smdrRecords.add(" 03/05 17:20:37  0000:00:05 9025         9999999999           00000A                                       001   19025                                   A0094199 A                                            ");
		
		boolean extendedDigitLengthSMDRRecordFields = true;
		
		for(String smdrRecord : smdrRecords) {
			SMDRRecord record = parser.parse(smdrRecord, extendedDigitLengthSMDRRecordFields);
			
			if(record == null) {
				throw new Exception("Unable to parse this SMDR : " + smdrRecord);
			}
			
			System.out.println("Record                 : " + smdrRecord);
			System.out.println("Long Call              : " + record.getLongCall());
			System.out.println("Date                   : " + record.getDate());
			System.out.println("Start Time             : " + record.getStartTime());
			System.out.println("Duration of Call       : " + record.getDurationOfCall());
			System.out.println("Calling Party          : " + record.getCallingParty());
			System.out.println("Time to Answer         : " + record.getTimeToAnswer());
			System.out.println("Digits Dialed          : " + record.getDigitsDialedOnTheTrunk());
			System.out.println("Meter Pulses           : " + record.getMeterPulses());
			System.out.println("Call Completion Status : " + record.getCallCompletionStatus());
			System.out.println("Speed Call             : " + record.getSpeedCall());
			System.out.println("Called Party           : " + record.getCalledParty());
			System.out.println("Transfer / Conf. Flag  : " + record.getTransferConferenceFlag());
			System.out.println("Third Party            : " + record.getThirdParty());
			System.out.println("Account Code           : " + record.getAccountCode());
			System.out.println("Route Optim. Flag      : " + record.getRouteOptimizationFlag());
			System.out.println("System Identifier      : " + record.getSystemIdentifier());
			System.out.println("ANI Number             : " + record.getAniNumber());
			System.out.println("DNIS Number            : " + record.getDnisNumber());
			
			System.out.println("Direction              : " + record.getDirection());
			
			System.out.println("");
		}
	}
}
