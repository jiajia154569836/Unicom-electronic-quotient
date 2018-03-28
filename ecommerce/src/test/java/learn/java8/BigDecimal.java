package learn.java8;

import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceCalculator;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.shape.Point;
import com.spatial4j.core.shape.Rectangle;

public class BigDecimal {

    private static double div(double dividend, double divisor, int len) {
        java.math.BigDecimal big1 = new java.math.BigDecimal(dividend);
        java.math.BigDecimal big2 = new java.math.BigDecimal(divisor);
        return big1.divide(big2, len, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {

        double distance =150000;
        double longitude =35;
        double latitude =35;
        double distanceKM = div(distance, 1000, 3);//单位转换：米转千米
        SpatialContext geo = SpatialContext.GEO;
        DistanceCalculator distanceCal = geo.getDistCalc();
        Point currentPoint = geo.makePoint(longitude, latitude);
        Rectangle rectangle = distanceCal.calcBoxByDistFromPt(currentPoint,
                distanceKM * DistanceUtils.KM_TO_DEG, geo, null);

        //todo 计算经纬度范围
        double lonMin, lonMax, latMin, latMax;
        lonMin = rectangle.getMinX();
        lonMax = rectangle.getMaxX();
        latMin = rectangle.getMinY();
        latMax = rectangle.getMaxY();
        System.out.println(lonMin);
        System.out.println(lonMax);
        System.out.println(latMin);
        System.out.println(latMax);

    }

}
