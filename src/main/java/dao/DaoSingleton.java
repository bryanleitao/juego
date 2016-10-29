package dao;

public  class DaoSingleton {

	private static DaoSingleton miconfigurador;

	private DaoSingleton(){
	}

	public  static DaoSingleton getConfigurador() {

		if (miconfigurador == null){

			miconfigurador = new DaoSingleton();
		}
		return miconfigurador;
	}
	
}