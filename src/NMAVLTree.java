public class NMAVLTree {
    Node root;

    /**
     *Height
     *
     * @param nd
     * @return
     */
    int height(Node nd){
        if(nd == null){
            return -1;
        }
        return nd.height;
    }

    /**
     * Checking balance
     * @param nd
     * @return
     */
    int checkBalance(Node nd){
        if(nd == null){
            return 0;
        }
        return height(nd.left) - height(nd.right);
    }

    /**
     * returns the higher value
     */
    public int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }

    public void add(int dat){
        root = add(root, dat); //kicks off recursion
    }

    Node add(Node nd, int dat){
        if(nd == null){
            return new Node(dat);
        }
        //BST insertion (this is basically the same as before)
        if(dat < nd.dat){ //does not allow dup keys (because of keymap reasons)
            nd.left = add(nd.left, dat);
        } else if(dat > nd.dat){
            nd.right = add(nd.right, dat);
        } else { //dat is ==
            return nd;
        }
        /* here is where rebalencning happens*/
        //update the height

        nd.height = max(height(nd.left), height(nd.right)) + 1;

        //check te balance
        int balance  = checkBalance(nd);

        if((balance > 1) && (dat < nd.left.dat)){ // left-left imbalance
            nd = rotateRight(nd);
        }
        //other imbalance cases go here//


        return nd;
    }

    Node rotateRight(Node C){
        System.out.println("rotate right->");

        Node B = C.left;
        Node Y = B.right;


        //rotate
        B.right = C;
        C.left = Y;

        //update the heights
        B.height = max(height(B.left), height(B.right));
        C.height = max(height(C.left), height(C.right));

        //return
        return B;

    }
}
