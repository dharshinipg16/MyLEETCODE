class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int len = mat.length;
        int lent = mat[0].length;

        int[][] fin = new int[len][lent];

        for (int i = 0; i < len; i++) {
            int[] arr = new int[lent];
            arr = mat[i].clone();

            if (i % 2 == 0) {
                // Left rotation
                int kt = k;
                while (kt > 0) {
                    int last = arr[0];
                    for (int p = 1; p < lent; p++) {
                        arr[p - 1] = arr[p];
                    }
                    arr[lent - 1] = last;
                    kt--;
                }
            } else {
                // Right rotation
                int kt = k;
                while (kt > 0) {
                    int last = arr[lent - 1];
                    for (int p = lent - 2; p >= 0; p--) {
                        arr[p + 1] = arr[p];
                    }
                    arr[0] = last;
                    kt--;
                }
            }
            fin[i] = arr;
        }

        boolean anst = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < lent; j++) {
                if (mat[i][j] != fin[i][j]) {
                    anst = false;
                }
            }
        }
        return anst;
    }
}

