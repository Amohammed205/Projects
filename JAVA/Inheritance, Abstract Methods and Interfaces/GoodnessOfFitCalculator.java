package module6;

import java.util.*;

//Interface for goodness of fit of Chi squared
public interface GoodnessOfFitCalculator {
	double GoodnessOfFit(Collection<DataPoint> data,Theory object);
}
