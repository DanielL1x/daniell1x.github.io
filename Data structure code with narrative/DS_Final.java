package com.company;

import java.util.Scanner;

    //Create the Nodes
    class Node{
       private String song;
        private  Node previous;
        private Node next;

        //create the links for nodes
        public Node()
        {
            next = null;
            previous = null;
            song = "";
        }

        //Construct the nodes
        public Node(String s, Node n, Node p){
            song = s;
            next = n;
            previous = p;
        }
        //setter for next link
        public void setNextLink(Node n)
        {
            next = n;
        }

        //setter for previous link
        public void setPreviousLink(Node p)
        {
            previous = p;
        }

        //getter for next link
        public Node getLinkNext()
        {
            return next;
        }

        //getter for previous link
        public Node getLinkPrev() {
            return previous;
        }

        //setter for song to enter
        public void setSong(String s)
        {
            song = s;
        }

        //getter for song
        public String getSong(){
            return song;
        }
    }

    //create class for doubly linked list and create the links for the nodes
    class DoublyLinkedList {
        private Node start;
        private Node end;
        public int playListSize;

        public DoublyLinkedList() {
            start = null;
            end = null;
            playListSize = 0;
        }

        public boolean isEmpty() {
            return start == null;
        }

        //get the size for playlist
        public int getPlayListSize() {
            return playListSize;
        }

        //Function to add song at any position
        public void insertAtPos(String tempValue, int pos) {
            Node newNode = new Node(tempValue, null,null);
            if (pos == 1) {
                insertAtFront(tempValue);
                return;
            }

            Node pointer = start;
            for (int i = 2; i <= playListSize; i++) {
                if (i == pos) {

                    Node temp = pointer.getLinkNext();
                    pointer.setNextLink(newNode);
                    newNode.setPreviousLink(pointer);
                    newNode.setNextLink(temp);
                    temp.setPreviousLink(newNode);

                }
                pointer = pointer.getLinkNext();
            }
            playListSize++;
        }

        public void insertAtFront(String tempValue) {
            Node newNode = new Node(tempValue,null,null);
            if (start == null) {
                newNode.setNextLink(newNode);
                newNode.setPreviousLink(newNode);
                start = newNode;
                end = start;
            } else {
                newNode.setPreviousLink(end);
                end.setNextLink(newNode);
                start.setPreviousLink(newNode);
                newNode.setNextLink(start);
                start = newNode;
            }
            playListSize++;
        }

        public void insertAtEnd(String tempValue) {
            Node newNode = new Node(tempValue,null,null);
            if (start == null) {

                newNode.setNextLink(newNode);
                newNode.setPreviousLink(newNode);
                start = newNode;
                end  = start;
            } else {
                newNode.setPreviousLink(end);
                end.setNextLink(newNode);
                start.setPreviousLink(newNode);
                newNode.setNextLink(start);
                end = newNode;
            }
            playListSize++;
        }

        public void deleteAtPos(int pos)
        {
            if (pos == 1)
            {
                if (playListSize == 1)
                {
                    start = null;
                    end = null;
                    playListSize = 0;
                    return;
                }
                start = start.getLinkNext();
                start.setPreviousLink(end);
                end.setNextLink(start);
                playListSize--;
                return ;
            }
            if (pos == playListSize)
            {
                end = end.getLinkPrev();
                end.setNextLink(start);
                start.setPreviousLink(end);
                playListSize-- ;
            }
            Node pointer = start.getLinkNext();
            for (int i = 2; i <= playListSize; i++)
            {
                if (i == pos)
                {
                    Node p = pointer.getLinkPrev();
                    Node n = pointer.getLinkNext();

                    p.setNextLink(n);
                    n.setPreviousLink(p);
                    playListSize-- ;
                    return;
                }
                pointer = pointer.getLinkNext();
            }
        }

            //display() will print out the nodes of the list
            public void display() {
//                System.out.print("\nCircular Doubly Linked List = ");
                Node pointer = start;
                if (playListSize == 0) {
                    System.out.print("empty\n");
                    return;
                }
                if (start.getLinkNext() == start) {
                    System.out.print(start.getSong() + " <> " + pointer.getSong() + "\n");
                    return;
                }
                System.out.print(start.getSong() + " <> ");
                pointer = start.getLinkNext();
                while (pointer.getLinkNext() != start) {
                    System.out.print(pointer.getSong() + " <> ");
                    pointer = pointer.getLinkNext();
                }
                System.out.print(pointer.getSong() + " <> ");
                pointer = pointer.getLinkNext();
                System.out.print(pointer.getSong() + "\n");
            }
            
        public static void main(String[] args) {
            DoublyLinkedList dList = new DoublyLinkedList();
            //Add nodes to the list
            Scanner scan = new Scanner(System.in);
            char button;

            //user options
            do {
                System.out.println("Playlist Creator\n\n" +
                        "press 1 to enter song at beginning\n" +
                        "press 2 to enter song at the end \n" +
                        "press 3 to enter song at any position\n" +
                        "press 4 for size and current songs\n" +
                        "press 5 to delete song at any position");

                int option = scan.nextInt();

                //switch case for user options
                switch (option) {

                    case 1:
                        System.out.println("Enter song to insert at beginning");
                        dList.insertAtFront(scan.next());
                        break;

                    case 2:
                        System.out.println("Enter song to insert at end");
                        dList.insertAtEnd(scan.next());
                        break;

                    case 3:
                        System.out.println("Enter song to insert");
                        String song = scan.next();
                        System.out.println("Enter position");
                        int pos = scan.nextInt() ;
                        if (pos < 1 || pos > dList.getPlayListSize() )
                            System.out.println("Enter position\n");
                        else
                            dList.insertAtPos(song, pos);
                        break;

                    case 4:
                        System.out.println("playListSize = "+ dList.getPlayListSize() +" \n");
                        break;

                    case 5:
                        System.out.println("Enter position");
                        int p = scan.nextInt() ;
                        if (p < 1 || p > dList.getPlayListSize() )
                            System.out.println("playlist is empty\n");
                        else
                            dList.deleteAtPos(p);
                        break;


                }


             //Ask user to continue and show current playlist
                dList.display();
                System.out.println("\nAdd another song? Type Y for yes or N for no) \n");
                button = scan.next().charAt(0);
            } while (button == 'Y'|| button == 'y');
            System.out.println("Final songs in playlist:");
            dList.display();

        }
    }

