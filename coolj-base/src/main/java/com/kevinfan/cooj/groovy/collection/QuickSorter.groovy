//quick sort with groovy

def quickSort(list) {
    if (list.size() < 2) {
        return list
    }

    def pivot = list[list.size().intdiv(2)]
    def left = list.findAll { e -> e < pivot }
    def middle = list.findAll { e -> e == pivot }
    def right = list.findAll { e -> e > pivot }

    return quickSort(left) + middle + quickSort(right)
}


def list = [4, 5, 2, 6, 7, 10, 1]
assert quickSort(list) == [1, 2, 4, 5, 6, 7, 10]