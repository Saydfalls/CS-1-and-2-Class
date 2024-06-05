class Circle {
    public int radius;
    public Point p = new Point(0, 0);

    public Point getCenter() {
        return p;
    };

    public int getRadius() {
        return radius;
    };

    public double getArea() {
        return (Math.PI * Math.pow(radius, 2));
    };

    public double getCircumference() {
        return (2 * radius * Math.PI);
    };

    public String printString() {
        return ("Circle [center=(" + p.getPointX() + "," + p.getPointY() + ") ,radius=" + radius + "]");
    };

    public Boolean testContains(Point i) {
        int X1 = i.getPointX();
        int Y1 = i.getPointY();
        int X2 = p.getPointX();
        int Y2 = p.getPointY();
        double Distance = Math.sqrt(Math.pow((X2 - X1), 2) + Math.pow((Y2 - Y1), 2));
        if (Distance >= radius) {
            return false;
        } else {
            return true;
        }
    };

    public Circle(Point Coords, int Radius) {
        this.p = Coords;
        this.radius = Radius;
    }

}
