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
	private String calledParty;
	private String transferConferenceFlag;
	private String thirdParty;
	private String accountCode;
	private String routeOptimizationFlag;
	private String systemIdentifier;
	private String aniNumber;
	private String dnisNumber;
	
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

	public String getCalledParty() {
		return calledParty;
	}

	public void setCalledParty(String calledParty) {
		this.calledParty = calledParty;
	}

	public String getTransferConferenceFlag() {
		return transferConferenceFlag;
	}

	public void setTransferConferenceFlag(String transferConferenceFlag) {
		this.transferConferenceFlag = transferConferenceFlag;
	}

	public String getThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(String thirdParty) {
		this.thirdParty = thirdParty;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getRouteOptimizationFlag() {
		return routeOptimizationFlag;
	}

	public void setRouteOptimizationFlag(String routeOptimizationFlag) {
		this.routeOptimizationFlag = routeOptimizationFlag;
	}

	public String getSystemIdentifier() {
		return systemIdentifier;
	}

	public void setSystemIdentifier(String systemIdentifier) {
		this.systemIdentifier = systemIdentifier;
	}

	public String getAniNumber() {
		return aniNumber;
	}

	public void setAniNumber(String aniNumber) {
		this.aniNumber = aniNumber;
	}

	public String getDnisNumber() {
		return dnisNumber;
	}

	public void setDnisNumber(String dnisNumber) {
		this.dnisNumber = dnisNumber;
	}

	public String getDirection() {
		if(this.callingParty == null || "".equals(this.callingParty.trim())) {
			return "I";
		}
		
		return "O";
	}
}
