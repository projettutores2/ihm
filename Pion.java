public class Pion
{
	private int x;
	private int y;
	private int z;

	private double[] tableauDirection;
	private int indiceDirection;

	//test
	private String[] tabOrdresPossedes;

	
	public Pion ( int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		/*this.tableauDirection = new double[]{-Math.PI, -0.67*Math.PI, -0.33*Math.PI, 0.33*Math.PI, 0.67*Math.PI, Math.PI};
		this.indiceDirection = -1;*/
		this.transformerCoordonnees(this.x, this.y, this.z);
		this.tabOrdresPossedes = new String[3];
	}
	
	public int getX() { return this.x; }
	public int getY() { return this.y; }
	/*public int getIndiceDirection(){return this.indiceDirection;}
	public double getDoubleDirection()
	{
		if (this.indiceDirection == -1)return 0;
		return this.tableauDirection[this.indiceDirection];
	}*/

	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	//public void setIndiceDirection(int i) { this.indiceDirection = i-1; }

	public void transformerCoordonnees(int x1, int y1, int z1)
	{
		this.setX((int)((x1-y1)*Math.sin(Math.PI*60/180)/(38 + 366)));
		this.setY((z1 * 38 * 3 + 500)/2);
	}

	public String[] getTabOrdres(){return this.tabOrdresPossedes;}

	public void setOrdres(int indice, String ordre){this.tabOrdresPossedes[indice]=ordre;}
	
}