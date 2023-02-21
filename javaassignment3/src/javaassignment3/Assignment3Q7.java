package javaassignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParkingSlot {
	private String ownerName;
	private int carNumber;
	private int token;
	private int level;
	private int section;
	private int slot;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

}

class Parked_CarOwnerDetails {

	private String ownerName;
	private String carModel;
	private int carNO;
	private long ownerMobileNo;
	private String ownerAddress;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarNO() {
		return carNO;
	}

	public void setCarNO(int carNO) {
		this.carNO = carNO;
	}

	public long getOwnerMobileNo() {
		return ownerMobileNo;
	}

	public void setOwnerMobileNo(long ownerMobileNo) {
		this.ownerMobileNo = ownerMobileNo;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

}

class Parked_CarOwnerList {
	int levels = 3;
	int sections = 4;
	int slots = 20;
	int levelCount = 0;
	int sectionCount = 0;
	int slotsCount = 0;
	int tokenCount = 101;
	List<Assignment3Q7> carOwners = new ArrayList<>();
	Map<Integer, ParkingSlot> parking = new HashMap<Integer, ParkingSlot>();
	Map<Integer, Parked_CarOwnerDetails> parkedCarOwnerDetails = new HashMap<>();

	public void setCarOwnerDetails(Assignment3Q7 obj) {
		Parked_CarOwnerDetails carOwnerDetails = new Parked_CarOwnerDetails();
		carOwnerDetails.setCarModel(obj.getCarModel());
		carOwnerDetails.setCarNO(obj.getCarNo());
		carOwnerDetails.setOwnerAddress(obj.getAddress());
		carOwnerDetails.setOwnerMobileNo(obj.getMobileNumber());
		carOwnerDetails.setOwnerName(obj.getName());
		parkedCarOwnerDetails.put(obj.getCarNo(), carOwnerDetails);
	}

	public void setParkingDetails(Assignment3Q7 obj) {
		ParkingSlot parkingSlot = new ParkingSlot();
		parkingSlot.setCarNumber(obj.getCarNo());
		parkingSlot.setLevel(levelCount);
		parkingSlot.setOwnerName(obj.getName());
		parkingSlot.setSection(sectionCount);
		parkingSlot.setSlot(slotsCount);
		parkingSlot.setToken(tokenCount);
		parking.put(tokenCount, parkingSlot);
		tokenCount++;
	}

	public void add_new_car(Assignment3Q7 obj) {
		boolean canPark = true;
		carOwners.add(obj);
		if (levelCount >= 3) {
			if (sectionCount >= 4) {
				if (slotsCount >= 20) {
					canPark = false;
					System.out.println("Sorry! You Can't park the car. Parking slots are full.");
				} else {
					slotsCount++;
				}
			} else {

				if (slotsCount >= 20) {
					sectionCount++;
				} else {
					slotsCount++;
				}
			}
		} else {
			if (sectionCount >= 4) {

				if (slotsCount >= 20) {
					levelCount++;
				} else {
					slotsCount++;
				}
			} else {

				if (slotsCount >= 20) {
					sectionCount++;
				} else {
					slotsCount++;
				}
			}

		}
		if (canPark == true) {
			setParkingDetails(obj);
			setCarOwnerDetails(obj);
		}
	}

	public void remove_car(int carNo) {
		for (Assignment3Q7 carowner : carOwners) {
			if (carowner.getCarNo() == carNo) {
				carOwners.remove(carowner);
				for (int tokens : parking.keySet()) {
					if (parking.get(tokens).getCarNumber() == carNo) {
						parking.remove(tokens);
						System.out.println("Car with Car number: " + carNo + " removed");
						break;
					}
				}

				break;
			}
		}
	}

	public String get_parked_car_location(int token) {
		String location = "You don't have any car parked.";
		if (parking.get(token) != null) {
			int level = parking.get(token).getLevel();
			int sections = parking.get(token).getSection();
			int slot = parking.get(token).getSlot();
			location = "Your car is at level: " + level + "  Section: " + sections + " Slot: " + slot;
		}
		return location;
	}
}

public class Assignment3Q7 {

	private String name;
	private String carModel;
	private int carNo;
	private int mobileNumber;
	private String address;

	public Assignment3Q7(String name, String carModel, int carNo, int mobileNumber, String address) {
		super();
		this.name = name;
		this.carModel = carModel;
		this.carNo = carNo;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static void main(String[] args) {

		Assignment3Q7 obj1 = new Assignment3Q7("Vanika Jaiswal", "Audi", 101, 928385492, "Bangalore");
		Assignment3Q7 obj2 = new Assignment3Q7("Abhi Jain", "Mahindra", 102, 638493929, "Delhi");
		Assignment3Q7 obj3 = new Assignment3Q7("Raman Gupta", "Hyundai", 103, 627183934, "Pune");
		Assignment3Q7 obj4 = new Assignment3Q7("Monish Kumar", "Tata", 104, 622339984, "Mumbai");

		Parked_CarOwnerList ownerList = new Parked_CarOwnerList();
		ownerList.add_new_car(obj1);
		ownerList.add_new_car(obj2);
		ownerList.add_new_car(obj3);
		ownerList.add_new_car(obj4);

		ownerList.remove_car(102);
		int token1 = 101;
		int token2 = 102;
		System.out.println(ownerList.get_parked_car_location(token1));

		if (ownerList.parking.get(token1) != null) {
			Parked_CarOwnerDetails ownerDetails1 = ownerList.parkedCarOwnerDetails
					.get(ownerList.parking.get(token1).getCarNumber());
			System.out.println("\nCar owner details -> \nOwner Full Name: " + ownerDetails1.getOwnerName()
					+ "\nOwner Car Model: " + ownerDetails1.getCarModel() + "\nOwner Car Number: "
					+ ownerDetails1.getCarNO() + "\nOwner Phone number: " + ownerDetails1.getOwnerMobileNo()
					+ "\nOwner Address: " + ownerDetails1.getOwnerAddress());
		}

		System.out.println("\n");

		System.out.println(ownerList.get_parked_car_location(token2));
		if (ownerList.parking.get(token2) != null) {
			Parked_CarOwnerDetails ownerDetails2 = ownerList.parkedCarOwnerDetails
					.get(ownerList.parking.get(token2).getCarNumber());
			System.out.println("\nCar owner details -> \nOwner Full Name: " + ownerDetails2.getOwnerName()
					+ "\nOwner Car Model: " + ownerDetails2.getCarModel() + "\nOwner Car Number: "
					+ ownerDetails2.getCarNO() + "\nOwner Phone number: " + ownerDetails2.getOwnerMobileNo()
					+ "\nOwner Address: " + ownerDetails2.getOwnerAddress());
		}
	}

}
