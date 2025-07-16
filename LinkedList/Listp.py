# Linked List implemntation of our List abstract data type in python 
import tkinter as tk
from tkinter import ttk 

''' Constants for the Window '''
WIDTH = 600
HEIGHT = 500
INSTRUCT = "METHODS: append(d),  prepend(d),  deleteAt(i),  size(),  getValueAt(i), " \
" positionOf(d)"

''' Constants for the text size and font '''
FT = "Times New Roman"
HSIZE = 25 # size for words in the header 
WSIZE = 14 # size ofr general words 

class Node:

    # CONSTRUCTOR 
    def __init__(self, data):
        self.data = data;
        self.next = None;
    

    # ACCESSORS 
    def getData(self):
        return self.data
    
    def getNext(self):
        return self.next
    

    # MUTATORS
    def setNext(self, next):
        self.next = next



class LinkedList:

    # CONSTRUCTOR 
    def __init__(self):
        self.head = self.tail = Node(None)
        self.count = 0;


    # FUNCTIONS
    # adds data to the back of LinkedList
    def append(self, data):
        node = Node(data)

        if (self.count == 0):
            self.head = node
        
        else:
            self.tail.setNext(node)

        self.tail = node
        self.count += 1
    
    # adds data to the front of Linked List
    def prepend(self, data):
        node = Node(data)

        if (self.count == 0):
            self.head = node 
        
        else:
            node.setNext(self.head) 

        self.head = self.tail 
        self.head = node
        self.count += 1

    # deletes data at index in linked list
    def deleteAt(self, position):
        position = int(position)
    
        # Handle out-of-bounds positions
        if position < 0 or position >= self.count:
            return("Invalid position")
            return

        cur = self.head

        if position == 0:
            self.head = cur.getNext()
            cur.setNext(None)
            self.count -= 1
            return

        i = 0
        prev = None
        while i < position:
            prev = cur
            cur = cur.getNext()
            i += 1

        # Remove current node
        prev.setNext(cur.getNext())
        cur.setNext(None)
        self.count -= 1

    
    # returns the size of list 
    def size(self):
        return self.count 
    
    # returns the value at the position 
    def getValueAt(self, position):
        position = int(position)
        cur = self.head
        
        if (position < 0 or position >= self.count):
            return("No Data At That Position")
        
        i = 0
        while (i < position):
            cur = cur.getNext()
            i += 1

        return(f"value({cur.getData()}) found at position({position})")
    
    # returns the position of data 
    def positionOf(self, value):
        cur = self.head
        position = 0

        while (position < self.count):
            if(cur.getData() == value):
                return(f"value({value}) -> position({position})")
            
            cur = cur.getNext() 
            position += 1
        
        return("Value Not Found")
           
    # prints all the contents in my  
    # linked list 
    def printAll(self):
        cur = self.head
        listContents = ""

        i = 0
        while (i < self.count):
            listContents += (f"{cur.getData()}, ")
            cur = cur.getNext()
            i += 1

        return listContents.rstrip(", ")


class Vizual(LinkedList):

    def __init__(self):
        super().__init__()
        self.list = LinkedList()
        self.base = tk.Tk()
        self.base.geometry("{}x{}".format(WIDTH, HEIGHT)) # size of window 
        self.base.title('Vizualization of LinkedList') # title for the app window 
        self.mainframe = tk.Frame(self.base, background='black')
        self.mainframe.pack(fill='both', expand=True)

        # entry box for command 
        self.entry = ttk.Entry(self.mainframe) 
        self.entry.place(relx=0.5, rely=0.8, anchor="center")

        # button for entry box 
        self.submit_button = tk.Button(
            self.mainframe, 
            text="Submit", 
            width=5, 
            height=1,
            command=self.parseInput
        )
        self.submit_button.place(relx=0.7, rely=0.8, anchor="center")

        # instructions 
        self.instruct_label = tk.Label(self.mainframe, text=INSTRUCT, bg="black", fg="white", font=(FT, 15))
        self.instruct_label.place(relx=0.5, rely=0.7, anchor="center")

        # text box to display list 
        self.list_label = tk.Label(self.mainframe, text="[ ... ]", bg="black", fg="white", font=(FT, 20))
        self.list_label.place(relx=0.5, rely=0.3, anchor="center")

        # display information about list 
        self.method_output = tk.Label(self.mainframe, text="", bg="black", fg="white", font=(FT, 20))
        self.method_output.place(relx=0.5, rely=0.6, anchor="center")

    

    # FUNCTIONS 

    def parseInput(self):
        user_input = self.entry.get()
        
        command_check = True
        data_check = True
        command = ""
        data = ""
        i = 0
        while (command_check):
            if (user_input[i] != '('):
                command += user_input[i]

            else:
                command_check = False
            i += 1

        while (data_check):
            if (user_input[i] != ')'):
                data += user_input[i]
            
            else:
                data_check = False
            i += 1

        self.handle_command(data, command)


    def handle_command(self, data, command):
        match command:
            case "append":
                self.list.append(data)
            case "prepend":
                self.list.prepend(data)
            case "deleteAt":
               self.list.deleteAt(data)
            case "getValueAt":
                self.method_output.config(text=(f"{self.list.getValueAt(data)}"))
            case "positionOf":
                self.method_output.config(text=(f"{self.list.positionOf(data)}"))
            case "size":
                self.method_output.config(text=(f"(Size of List -> {self.list.size()})"))

        self.display()
    
    def display(self):
        self.list_label.config(text=(f"[ {self.list.printAll()} ]"))


# ################################################
# MAIN APP LOOP 
if __name__ == "__main__":
    app = Vizual()
    app.base.mainloop()






        

