public class Rectangle {
    
    private int width;
    private int height;
    private int x;
    private int y;
    public Rectangle(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public int getx()
    {
        return this.x;
    }
    public int gety()
    {
        return this.y;
    }
    public int getwidth()
    {
        return this.width;
    }
    public int getheight()
    {
        return this.height;
    }
    public void setx2(int x)
    {
        this.x -= x;
    }
    public void sety2(int y)
    {
        this.y -= y;
    }
    public void setwidth(int width)
    {
        this.width = width;
    }
    public void setheight(int height)
    {
        this.height = height;
    }
    public void setx(int x)
    {
        this.x = x;
    }
    public void sety(int y)
    {
        this.y = y;
    }
    
       
    
}

