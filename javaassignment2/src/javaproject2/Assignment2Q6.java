package javaproject2;

abstract class Persistence {
	abstract public String persist();
}

class FilePersistence extends Persistence {
	@Override
	public String persist() {
		return "Data is saved in file.";
	}
}

class DatabasePersistence extends Persistence {
	@Override
	public String persist() {
		return "Data is saved in database.";
	}
}

public class Assignment2Q6 {

	public static void main(String[] args) {
		Persistence persistence = new FilePersistence();
		System.out.println(persistence.persist());
		persistence = new DatabasePersistence();
		System.out.println(persistence.persist());
	}

}