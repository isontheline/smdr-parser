package io.isontheline.smdr;

public class SMDRRecord {
	private String longCall;
	private String date;
	private String startTime;
	private String durationOfCall;
	private String callingParty;
	private String timeToAnswer;
	private String digitsDialedOnTheTrunk;
	private String meterPulses;
	private String callCompletionStatus;
	private String speedCall;
	
	public String getLongCall() {
		return longCall;
	}
	
	public void setLongCall(String longCall) {
		this.longCall = longCall;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getDurationOfCall() {
		return durationOfCall;
	}
	
	public void setDurationOfCall(String durationOfCall) {
		this.durationOfCall = durationOfCall;
	}
	
	public String getCallingParty() {
		return callingParty;
	}
	
	public void setCallingParty(String callingParty) {
		this.callingParty = callingParty;
	}
	
	public String getTimeToAnswer() {
		return timeToAnswer;
	}
	
	public void setTimeToAnswer(String timeToAnswer) {
		this.timeToAnswer = timeToAnswer;
	}
	
	public String getDigitsDialedOnTheTrunk() {
		return digitsDialedOnTheTrunk;
	}
	
	public void setDigitsDialedOnTheTrunk(String digitsDialedOnTheTrunk) {
		this.digitsDialedOnTheTrunk = digitsDialedOnTheTrunk;
	}
	
	public String getMeterPulses() {
		return meterPulses;
	}

	public void setMeterPulses(String meterPulses) {
		this.meterPulses = meterPulses;
	}

	public String getCallCompletionStatus() {
		return callCompletionStatus;
	}

	public void setCallCompletionStatus(String callCompletionStatus) {
		this.callCompletionStatus = callCompletionStatus;
	}

	public String getSpeedCall() {
		return speedCall;
	}

	public void setSpeedCall(String speedCall) {
		this.speedCall = speedCall;
	}

	public String getDirection() {
		if(this.callingParty == null || "".equals(this.callingParty.trim())) {
			return "I";
		}
		
		return "O";
	}
}
