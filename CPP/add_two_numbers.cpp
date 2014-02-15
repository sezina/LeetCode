class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        int carry = 0;
        int temp_sum = 0;
        ListNode *result_l = NULL, *last_one;
        while (l1 != NULL && l2 != NULL) {
            temp_sum = l1->val + l2->val + carry;
            if (temp_sum > 9) {
                carry = 1;
                temp_sum -= 10;
            } else {
                carry = 0;
            }
            if (result_l == NULL) {
                result_l = last_one = new ListNode(temp_sum);
            } else {
                last_one->next = new ListNode(temp_sum);
                last_one = last_one->next;
            }
            l1 = l1->next;
            l2 = l2->next;
        }
        
        ListNode *copy_l;
        if (l1 != NULL) {
            copy_l = l1;
        } else {
            copy_l = l2;
        }
        
        while (copy_l != NULL) {
            temp_sum = copy_l->val + carry;;
            if (temp_sum > 9) {
                carry = 1;
                temp_sum -= 10;
            } else {
                carry = 0;
            }
            last_one->next = new ListNode(temp_sum);
            last_one = last_one->next;
            copy_l = copy_l->next;
        }
        
        if (carry) {
            last_one->next = new ListNode(carry);
        }
        return result_l;
    }
};
