from turtle import *
import colorsys

speed(0)
hideturtle()
pensize(2)
bgcolor("black")

petals = 18
for i in range(petals):
    # Hue rotates around the color wheel for each petal
    base_h = i / petals

    for j in range(18):
        # Add a small hue shift per ring to create a richer gradient
        h = (base_h + j * 0.01) % 1.0
        s = 0.9
        v = 0.6 + 0.4 * (j / 17)
        c = colorsys.hsv_to_rgb(h, s, v)
        color(c)

        circle(180 - j * 7, 60)
        lt(120)
        circle(180 - j * 7, 60)
        rt(120)

    rt(360 / petals)

penup()
home()
pendown()
fillcolor("yellow")
begin_fill()
circle(40)
end_fill()

done()