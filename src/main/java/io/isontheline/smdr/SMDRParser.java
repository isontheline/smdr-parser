package io.isontheline.smdr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SMDRParser {
	public SMDRRecord parse(String smdrRecord, boolean extendedDigitLengthSMDRRecordFields) {
		int durationOfCallMaxHourDigits = 2;
		int durationOfCallMaxDigits = 8;
		int callingPartyMaxDigits = 4;
		int timeToAnswerMaxDigits = 3;
		
		if(extendedDigitLengthSMDRRecordFields == true) {
			durationOfCallMaxHourDigits = 4;
			durationOfCallMaxDigits = 10;
			callingPartyMaxDigits = 7;
			timeToAnswerMaxDigits = 4;
		}
		
		String pattern = "";
		
		// Long Call
		pattern += "([\\s\\-%\\+])"; 							
		
		// Date
		pattern += "([0-9]{2,2}/[0-9]{2,2})"; 					
		
		// Spacer
		pattern += "\\s"; 										 
		
		// Start Time
		pattern += "([0-9]{2,2}:[0-9]{2,2}:[0-9]{2,2}[\\sP])"; 	
		
		// Spacer
		pattern += "\\s"; 										
		
		// Duration of Call
		pattern += "(([0-9]{2," + durationOfCallMaxHourDigits + "}:[0-9]{2,2}:[0-9]{2,2})"; 
		pattern += "|"; // OR
		pattern += "([\\s]{" + durationOfCallMaxDigits + "," + durationOfCallMaxDigits + "}))";
		
		// Spacer
		pattern += "\\s";
		
		// Calling Party
		pattern += "([0-9\\s]{4," + callingPartyMaxDigits + "})"; 
		
		// Spacer
		pattern += "\\s";
				
		// Time to Answer
		pattern += "([0-9\\*\\s]{" + timeToAnswerMaxDigits + "," + timeToAnswerMaxDigits + "})"; 
		
		// Spacer
		pattern += "\\s";
		
		// Digits Dialed on the Trunk
		pattern += "([0-9\\s]{20,20})"; 
		
		// Spacer
		pattern += "\\s";
		
		// Meter pulses
		pattern += "([0-9\\s]{5,5})"; 
		
		// Call Completion Status
		pattern += "([ABETIP\\s]{1,1})"; 
		
		// Speed Call/Call Forward Flag
		pattern += "([SF\\s]{1,1})"; 
		
		Pattern smdrPattern = Pattern.compile(pattern);
		
		Matcher m = smdrPattern.matcher(smdrRecord);
		
		if(m.find() == false) {
			return null;
		}
		
		String longCall 				= m.group(1);
		String date 					= m.group(2);
		String startTime 				= m.group(3);
		String durationOfCall 			= m.group(4);
		String callingParty				= m.group(7);
		String timeToAnswer				= m.group(8);
		String digitsDialedOnTheTrunk 	= m.group(9);
		String meterPulses				= m.group(10);
		String callCompletionStatus		= m.group(11);
		String speedCall				= m.group(12);
		
		SMDRRecord result = new SMDRRecord();
		result.setLongCall(longCall);
		result.setDate(date);
		result.setStartTime(startTime);
		result.setDurationOfCall(durationOfCall);
		result.setCallingParty(callingParty);
		result.setTimeToAnswer(timeToAnswer);
		result.setDigitsDialedOnTheTrunk(digitsDialedOnTheTrunk);
		result.setMeterPulses(meterPulses);
		result.setCallCompletionStatus(callCompletionStatus);
		result.setSpeedCall(speedCall);
		
		return result;
	}
}
