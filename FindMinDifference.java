//12:01
//10:59
//convert to total minutes and sort
//compare ajacent value to get the minimum difference
class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() == 0)
            return 0;
        
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            int totalMinutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
            minutes.add(totalMinutes);
        }
        //sort the total minutes array list
        Collections.sort(minutes, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });
        
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.size() - 1; i++) {
            minDiff = Math.min(minutes.get(i + 1) - minutes.get(i), minDiff);
        }
        
        //22:14, 23:59
        //00:00 23:59
        int corner = minutes.get(0) + (1440 - minutes.get(minutes.size() - 1));
        return Math.min(minDiff, corner);
    }
}
