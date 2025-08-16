class StringArrays {
    // Returns the longest name in the array
    public static String findLongestName(String[] names) {
        if (names == null || names.length == 0) return null;
        String longest = names[0];
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    // Counts how many names start with the given letter (case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        if (names == null) return 0;
        int count = 0;
        char target = Character.toLowerCase(letter);
        for (String name : names) {
            if (name.length() > 0 && Character.toLowerCase(name.charAt(0)) == target) {
                count++;
            }
        }
        return count;
    }

    // Formats all names to "Last, First" format
    public static String[] formatNames(String[] names) {
        if (names == null) return new String[0];
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2) {
                formatted[i] = parts[1] + ", " + parts[0];
            } else {
                formatted[i] = names[i]; // If not "First Last", keep as is
            }
        }
        return formatted;
    }

    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown",
                             "Carol Davis", "David Wilson"};

        // Test findLongestName
        System.out.println("Longest name: " + findLongestName(students));

        // Test countNamesStartingWith
        char letter = 'A';
        System.out.println("Names starting with '" + letter + "': " +
            countNamesStartingWith(students, letter));

        // Test formatNames
        String[] formatted = formatNames(students);
        System.out.println("Formatted names:");
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}