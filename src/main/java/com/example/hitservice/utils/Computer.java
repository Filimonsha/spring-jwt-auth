package com.example.hitservice.utils;

public class Computer {

    public static boolean calculateHit(Double x,Double y,Double r){
        return isHitting(x, y, r);
    }

    private static boolean isHitting(Double x,Double y,Double r) {
        Point point = new Point(x,y);

        // north-condition
        if ((point.x() <= r / 2 && point.x() >= 0) && (point.y() <= r && point.y() >= 0)) {
            return true;
        }
        // south-east-condition
        else // missing
            if (isHittingTriangle(point, r, new Point(0, 0), new Point(0, r), new Point(r, 0))) {
            return true;
        }
        // south-west-condition                                 // length
        else return (point.x() <= 0 && point.y() < 0) && (Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2)) <= r);
    }

    private static boolean isHittingTriangle(Point point, double r, Point apex1, Point apex2, Point apex3) {
        double condition1 = (apex1.x() - point.x()) * (apex2.y() - apex1.y()) - (apex2.x() - apex1.x()) * (apex1.y() - point.y());
        double condition2 = (apex2.x() - point.x()) * (apex3.y() - apex2.y()) - (apex3.x() - apex2.x()) * (apex2.y() - point.y());
        double condition3 = (apex3.x() - point.x()) * (apex1.y() - apex3.y()) - (apex1.x() - apex3.x()) * (apex3.y() - point.y());
        return (condition1 >= 0 && condition2 >= 0 && condition3 >= 0) || (condition1 <= 0 && condition2 <= 0 && condition3 <= 0);
    }
}

record Point(double x, double y) {
}