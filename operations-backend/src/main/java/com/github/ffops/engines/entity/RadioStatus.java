package com.github.ffops.engines.entity;

public enum RadioStatus {

	READY_AT_STATION(1), READY_AT_RADIO(2), ACCEPTED(4), ARRIVED_AT_DESTINATION(4), NEEDS_TO_TALK(5), NOT_READY(6);

	private int radioStatus;

	private RadioStatus(int radioStatus) {
		this.radioStatus = radioStatus;
	}

	public int getRadioStatus() {
		return radioStatus;
	}

	@Override
	public String toString() {
		return String.valueOf(radioStatus);
	}

	public static RadioStatus fromString(String radiostatus) {
		switch (Integer.valueOf(radiostatus)) {
		case 1:
			return READY_AT_STATION;
		case 2:
			return READY_AT_RADIO;
		case 3:
			return ACCEPTED;
		case 4:
			return ARRIVED_AT_DESTINATION;
		case 5:
			return NEEDS_TO_TALK;
		case 6:
			return NOT_READY;
		default:
			return NOT_READY;
		}

	}

}
