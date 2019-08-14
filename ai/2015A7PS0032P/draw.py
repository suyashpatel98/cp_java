#2015A7PS0032P Suyash Patel

#Game initialised


import turtle

def drawLines() :
    turtle.speed(0)
    # Horizontal Lines
    turtle.pensize(2)
    turtle.penup()
    turtle.goto(-180,140)
    turtle.pendown()
    turtle.goto(180,140)

    turtle.penup()
    turtle.goto(-240, 80)
    turtle.pendown()
    turtle.goto(240, 80)

    turtle.penup()
    turtle.goto(-300, 20)
    turtle.pendown()
    turtle.goto(300, 20)

    turtle.penup()
    turtle.goto(-240, -40)
    turtle.pendown()
    turtle.goto(240, -40)

    turtle.penup()
    turtle.goto(-180, -100)
    turtle.pendown()
    turtle.goto(180, -100)
    turtle.penup()
    # End horizontal lines
    turtle.goto(180, 140)
    turtle.pendown()
    turtle.goto(300, 20)
    turtle.penup()

    turtle.goto(60, 140)
    turtle.pendown()
    turtle.goto(240, -40)
    turtle.penup()

    turtle.goto(-60, 140)
    turtle.pendown()
    turtle.goto(180, -100)
    turtle.penup()

    turtle.goto(-180, 140)
    turtle.pendown()
    turtle.goto(60, -100)
    turtle.penup()

    turtle.goto(-240, 80)
    turtle.pendown()
    turtle.goto(-60, -100)
    turtle.penup()

    turtle.goto(-300, 20)
    turtle.pendown()
    turtle.goto(-180, -100)
    turtle.penup()

    # End / lines
    # Start \ lines
    turtle.goto(-180, 140)
    turtle.pendown()
    turtle.goto(-300, 20)
    turtle.penup()

    turtle.goto(-60, 140)
    turtle.pendown()
    turtle.goto(-240, -40)
    turtle.penup()

    turtle.goto(60, 140)
    turtle.pendown()
    turtle.goto(-180, -100)
    turtle.penup()

    turtle.goto(180, 140)
    turtle.pendown()
    turtle.goto(-60, -100)
    turtle.penup()

    turtle.goto(240, 80)
    turtle.pendown()
    turtle.goto(60, -100)
    turtle.penup()

    turtle.goto(300, 20)
    turtle.pendown()
    turtle.goto(180, -100)
    turtle.penup()


def drawOlympicCircle(x, y, color, radius):
    turtle.pensize(2)
    turtle.penup()
    turtle.speed(0)
    turtle.setposition(x, y)
    turtle.pendown()
    turtle.color("black",color)
    turtle.begin_fill()
    turtle.circle(radius)
    turtle.end_fill()


def drawOlympicLogo(radius):
    positions = [(60, -120, 'green'),(-60, -120, 'blue'),(180,-120,'blue'),(-180,-120,'blue'),
                 (240,-60,'white'),(120, -60, 'white'),(0, -60, 'green'),(-120, -60, 'white'),(-240,-60,'blue'),
                 (-300,0,'green'),(60, 0, 'blue'), (-60, 0, 'blue'), (180, 0, 'green'), (-180, 0, 'blue'),(300,0,'green'),
                 (240, 60, 'green'), (120, 60, 'green'), (0, 60, 'green'), (-120, 60, 'blue'), (-240, 60, 'green'),
                 (60, 120, 'green'), (-60, 120, 'white'), (180, 120, 'blue'), (-180, 120, 'blue')
     ]
    for position in positions:
        drawOlympicCircle(position[0],
                          position[1],
                          position[2],
                          radius)
    turtle.done()

drawLines()
drawOlympicLogo(20)
