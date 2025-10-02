class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int bottles =numBottles;

        while(numBottles >= numExchange) {
            numBottles = numBottles - numExchange + 1;
            bottles++;
            numExchange++;
        }
        return bottles;
    }
}