class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        long sum = 0l;

        //adding to max pq
        for(int gift : gifts){
            sum += gift;
            pq.offer(gift);
        }

        //calculate squareroot and offer to pq
        for(int i=0; i<k; i++){
            if(pq.isEmpty()) break;
            int max = pq.poll();
            int  sqrt = (int) Math.sqrt(max);
            sum -= (max - sqrt);
            pq.offer(sqrt);
        }

        //return sum
        return sum;
    }
}

//TC : O(2n)
//SC : O(n)