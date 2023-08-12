pub fn do_reverse_list<T>(input: &[T]) -> Vec<T>
where
    T: Copy,
{
    let mut output = Vec::with_capacity(input.len());

    for e in input.iter().rev() {
        output.push(*e);
    }

    output
}

pub fn do_fibonacci_sequence(sequence_length: usize) -> Vec<u64> {
    let mut sequence = Vec::with_capacity(sequence_length);

    if sequence_length >= 1 {
        sequence.push(1);
    }
    if sequence_length >= 2 {
        sequence.push(1);
    }
    for i in 2..sequence_length {
        sequence.push(sequence[i - 1] + sequence[i - 2]);
    }

    sequence
}

// We could make the is_(a|de)scending_series functions more generic
// by using the Integer trait from the external 'num' crate.
pub fn is_ascending_series(series: &[i64]) -> bool {
    for n in series.windows(2) {
        if n[0] > n[1] {
            return false;
        }
    }

    true
}

pub fn is_descending_series(series: &[i64]) -> bool {
    for n in series.windows(2) {
        if n[0] < n[1] {
            return false;
        }
    }

    true
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_reverse_list() {
        let input = vec!["a", "b", "c", "d", "e", "f", "g"];
        let expected_result = vec!["g", "f", "e", "d", "c", "b", "a"];

        let result = do_reverse_list(&input);

        assert_eq!(result, expected_result);
    }

    #[test]
    fn test_fibonacci_sequence() {
        let sequence_length = 8;
        let expected_result = vec![1, 1, 2, 3, 5, 8, 13, 21];
        let result = do_fibonacci_sequence(sequence_length);

        assert_eq!(expected_result, result);
    }

    #[test]
    fn test_ascending_and_descending_series() {
        let test_series_a = vec![1, 2, 5, 8, 15, 27, 31, 50];
        let test_series_b = vec![1, 2, 1, 8, 7, 27, 31, 50];

        assert!(is_ascending_series(&test_series_a));
        assert!(!is_ascending_series(&test_series_b));
        assert!(is_descending_series(&do_reverse_list(&test_series_a)));
        assert!(!is_descending_series(&do_reverse_list(&test_series_b)));
    }
}
