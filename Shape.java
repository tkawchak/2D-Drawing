package drawing2d;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics2D;

// class that all the other shapes will inherit from
public abstract class Shape{
    private String label;  // type of shape
    private Color color1;  // primary color
    private Color color2;  // secondary color
    private Point begin;  // start point of the drawing
    private Point end;  // the end point of the drawing
    private boolean fill;  // specifies to fill or leave a shape blank
    private boolean gradient;  // specifies to have a gradient or not
    private boolean dashed;  // specifies dashed lines or solid
    private int width;  // width of the lines
    private int dash;  // length of dashed lines
    
    // generic shape constructor to store values
    public Shape() { }
    
    public Shape(Shape newShape) {
        color1 = newShape.getColor1();
        color2 = newShape.getColor2();
        begin = newShape.getBegin();
        end = newShape.getEnd();
        fill = newShape.isFill();
        gradient = newShape.isGradient();
        dashed = newShape.isDashed();
        width = newShape.getWidth();
        dash = newShape.getDash();
    }
        
    // called to draw the shape to the drawing
    abstract void draw(Graphics2D g2d);
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public void setGradient(boolean gradient) {
        this.gradient = gradient;
    }

    public void setDashed(boolean dashed) {
        this.dashed = dashed;
    }

    public void setDash(int dash) {
        this.dash = dash;
    }

    public Color getColor1() {
        return color1;
    }

    public Color getColor2() {
        return color2;
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }

    public boolean isFill() {
        return fill;
    }

    public boolean isGradient() {
        return gradient;
    }

    public boolean isDashed() {
        return dashed;
    }

    public int getWidth() {
        return width;
    }

    public int getDash() {
        return dash;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
