# Magic square
#Suyash Patel
#2015A7PS0032P

import turtle

n = int(input())
arr = []
use = []

def check_constraints(n,arr) :
    magic_constant = int(n*(n*n + 1)/2)
    #traverse all rows
    curr = 0
    for i in range(n):
        curr = 0
        for j in range(n):
            curr = curr + arr[i][j]
        if(curr != magic_constant) : return False

    #traverse all cols
    curr = 0
    for i in range(n):
        curr = 0
        for j in range(n):
            curr = curr + arr[j][i]
        if(curr != magic_constant) : return False

    #traverse all diagonals
    curr = 0
    for i in range(n):
            curr = curr + arr[i][i]
    if(curr != magic_constant) : return False
    curr = 0
    for i in range(n):
            curr = curr + arr[i][n-1-i]
    if (curr != magic_constant) : return False
    return True


def swap(use,i,j) :
    temp = use[i]
    use[i] = use[j]
    use[j] = temp



def backtrack(use,l,r) :
    if(l == r) :
        for i in range(0,n) :
            for j in range(0,n) :
                arr[i][j] = use[n*i+j]
        res = check_constraints(n,arr)
        if(res) :
            return True
    else :
        for i in range(l,r+1) :
            swap(use,l,i)
            if(backtrack(use,l+1,r)) : return True
            swap(use,l,i)
    return False
count = 1
for i in range(0,n):
    arr.append([])
    for j in range(0,n):
        arr[i].append(count)
        use.append(count)
        count = count + 1


res = backtrack(use,0,len(use)-1)
if(res) : print("Solution found")


def draw_box(t,x,y,size,arr,m,k):
    t.penup() # no drawing!
    t.goto(x,y) # move the pen to a different position
    t.pendown() # resume drawing
    for i in range(0,4):
        board.forward(size) # move forward
        board.right(90) # turn pen right 90 degrees
    t.penup()
    t.goto(x+size/2,y-size/2)
    t.write(arr[m][k], True, align = "center")


wn = turtle.Screen()
wn.title("assignment 4 : Magic Square")
#wn.tracer(0)
board = turtle.Turtle()
start_x = 50 # starting x position of the grid
start_y = 50 # starting y position of the grid
box_size = 30 # pixel size of each box in the grid
for i in range(0,n): # 3x3 grid
    for j in range(0,n):
        draw_box(board,start_x + j*box_size, start_y + i*box_size, box_size,arr,n-1-i,j)
        #
#wn.update()

turtle.done()
