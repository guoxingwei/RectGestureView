package bean;

/**
 * Created by jh on 2018/3/5.
 */

public class Point {

    public Point(int pointRadius) {
        this.pointRadius = pointRadius;
    }

    public int getPointRadius() {
        return pointRadius;
    }

    public void setPointRadius(int pointRadius) {
        this.pointRadius = pointRadius;
    }

    private int pointRadius;
}
