package drawing2d;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.geom.Line2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.geom.Point2D;

public class Line extends Shape{
    private Color color1;  // primary color
    private Color color2;  // secondary color
    private Point begin;  // start point of the drawing
    private Point end;  // the end point of the drawing
    private boolean fill;  // specifies to fill or leave a shape blank
    private boolean gradient;  // specifies to have a gradient or not
    private boolean dashed;  // specifies dashed lines or solid
    private int width;  // width of the lines
    private int dash;  // length of dashed lines
    
    // constructor to store values
    public Line(Shape newShape) {
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
    void draw(Graphics2D g2d){
        Point2D start = (Point2D) getBegin();
        Point2D finish = (Point2D) getEnd();
        
        float dashLength = (float) getDash();
        float dashWidth = (float) getWidth();

        if (isGradient()) {
            g2d.setPaint(new GradientPaint(start, getColor1(), finish, getColor2()));
        }
        else {
            g2d.setPaint(getColor1());
        }
        
        if (!isDashed()) {
            g2d.setStroke (new BasicStroke(dashWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 50f, new float[] {1f}, 0f));
        }
        else {
            g2d.setStroke (new BasicStroke(dashWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 50f, new float[] {dashLength}, 0f));
        }
        g2d.draw(new Line2D.Double(getBegin(), getEnd()));
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Point getBegin() {
        return begin;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public boolean isGradient() {
        return gradient;
    }

    public void setGradient(boolean gradient) {
        this.gradient = gradient;
    }

    public boolean isDashed() {
        return dashed;
    }

    public void setDashed(boolean dashed) {
        this.dashed = dashed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDash() {
        return dash;
    }

    public void setDash(int dash) {
        this.dash = dash;
    }
}
