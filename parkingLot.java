public Class ParkingLot {

	private String parkingLotId;
	private Address address;
	private List<ParkingFloor> parkingFloors;
	private List<Entrance> entrances;
	private List<Exit> exits;

	public boolean isParkingSpaceAvailableForParkingSpaceType(ParkingSpaceType parkingSpaceType);
	public assigneParkingAttendantToEachGate(ParkingAttendant parkingAttendant, int gateId);

}

Class ParkingFloor {

	private ParkingDisplayBoard parkingDisplayBoard;
	private List<ParkingSpace> parkingSpaces;
	private int levelId;
}

abstract Class Gate {

	private int gateId;
	private ParkingAttendant parkingAttendant;


}

Class Entrance extends Gate {

	public ParkingTicket getParkingTicket(ParkingSpaceType parkingSpaceType);
}

Class Exit extends Gate{

	public ParkingTicket payForParking(ParkingSpace parkingSpace, PaymentType paymentType);

}

Class Address {

	private String country;
	private String city;
	private String state;
	private int pin;
	private String AddressLine1;
	private String AddressLine2;
}

Class ParkingSpace {

	private String parkingSpaceId;
	private ParkingSpaceType parkingSpaceType;
	private boolean isReserved;
	private double costPerHour;
}

Class ParkingDisplayBoard {

	private Map<ParkingSpaceType,Integer> freeParkingSpace;
	private String parkingDisplayBoardId;

	public void updateFreeParkingSpaces(ParkingSpaceType parkingSpaceType, int freeParkingSpace);
}

Class Employee {

	private String employeeName;
	private Sring employeeId;
	private String employeeEmail;
	private Address address;
}

Class Admin extends Employee {

	public boolean addParkingFloor(ParkingFloor parkingFloor, ParkingLot parkingLot);
	public boolean addEntrance(ParkingLot parkinglot, Entrance entrance);
	public boolean addExit(ParkingLot parkinglot, Exit exit);
	public boolean addParkingDisplayBoard(ParkingFloor floor, ParkingDisplayBoard parkingDisplayBoard);

}

Class ParkingAttendant extends Employee {

	private PaymentService paymentService;

	public ParkingTicket issueParkingTicket(ParkingSpace parkingSpace);
	public PaymentInvoice processPayment(ParkingTicket parkingTicket, PaymentType paymentType);
}

Class PaymentService {

	public PaymentInvoice makePayment(PaymentType paymentType, double costToBePaid, String parkingticketId);
}

Enum ParkingSpaceType {

	TWO_WHEELER_SMALL_PARKING, TWO_WHEELER_LARGE_PARKING, FOUR_WHEELER_SMALL_PARKING, FOUR_WHEELER_LARGE_PARKING;
}

Class ParkingTicket {

	private String VehicleLicenseNumber;
	private Date entryTime;
	private Date exitTime;
	private double ticketCost;
	private String parkingSpaceId;
	private String parkingticketId;
	private ParkingTicketStatus parkingTicketStatus;

	public void updateTotalCost();
	public void updateExitTimeAndStatus();
}

Class PaymentInvoice {

	private String transactionId;
	private String parkingTicketId;
	private double amountPaid;
	private PaymentType paymentType;
	private Date paymentDate;
	private PaymentStatus paymentStatus;
}

Enum PaymentType {
	CASH, CREDIT_CARD, DEBIT_CARD, UPI;
}

Enum ParkingTicketStatus {
	PAID, ACTIVE;
}

Enum PaymentStatus {
	COMPLETED, REFUNDED, PENDING, CANCELLED, DECLINED;
}


