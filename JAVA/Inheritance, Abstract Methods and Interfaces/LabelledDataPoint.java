package module6;

public class LabelledDataPoint extends DataPoint {

	protected String LDP;

	//Constructor
	public LabelledDataPoint(String LDP, double x,double y, double ey) {
		super(x,y,ey);
		this.LDP = LDP;
	}

	public String toString (){
		return (this.LDP+": " +super.toString());
	}

}
