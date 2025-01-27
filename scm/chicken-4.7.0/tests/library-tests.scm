;;;; library-tests.scm

(use srfi-1)


;; numbers

(assert (= -4.0 (round -4.3)))
(assert (= 4.0 (round 3.5)))
(assert (= 4 (round (string->number "7/2"))))
(assert (= 7 (round 7)))
(assert (zero? (round -0.5))) 		; is actually -0.0
(assert (zero? (round -0.3)))
(assert (= -1 (round -0.6)))
(assert (zero? (round 0.5)))
(assert (zero? (round 0.3)))
(assert (= 1.0 (round 0.6)))
(assert (rational? 1))
(assert (rational? 1.0))
(assert (not (rational? +inf.)))
(assert (not (rational? 'foo)))

(define-syntax assert-fail
  (syntax-rules ()
    ((_ exp)
     (assert (handle-exceptions ex #t exp #f)))))

(assert-fail (/ 1 1 0))
(assert-fail (/ 1 1 0.0))
(assert-fail (/ 1 0.0))
(assert-fail (/ 1 0))
(assert-fail (/ 0))
(assert-fail (/ 0.0))

(assert (fixnum? (/ 1)))

(assert (= -3 (- 3)))
(assert (= 3 (- -3)))
(assert (= 2 (- 5 3)))
(assert (> 1 (/ 3)))
(assert (> 1 (/ 3.0)))
(assert (= 2 (/ 8 4)))
(assert (zero? (+)))
(assert (= 1 (*)))

(assert (= 2.5 (/ 5 2)))


;; number->string conversion

(for-each
 (lambda (x)
   (let ((number (car x))
	 (radix (cadr x)))
     (assert (eqv? number (string->number (number->string number radix) radix)))))
 '((123 10)
   (123 2)
   (123 8)
   (-123 10)
   (-123 2)
   (-123 8)
   (99.2 10)
   (-99.2 10)))

;; by Christian Kellermann
(assert 
 (equal?
  (map (lambda (n) (number->string 32 n)) (iota 15 2))
  '("100000" "1012" "200" "112" "52" "44" "40" "35" "32" "2A" "28" "26" "24" "22" "20")))


;; fp-math

(assert (= (sin 42.0) (fpsin 42.0)))
(assert (= (cos 42.0) (fpcos 42.0)))
(assert (= (tan 42.0) (fptan 42.0)))
(assert (= (asin 0.5) (fpasin 0.5)))
(assert (= (acos 0.5) (fpacos 0.5)))
(assert (= (atan 0.5) (fpatan 0.5)))
(assert (= (atan 42.0 1.2) (fpatan2 42.0 1.2)))
(assert (= (exp 42.0) (fpexp 42.0)))
(assert (= (log 42.0) (fplog 42.0)))
(assert (= (expt 42.0 3.5) (fpexpt 42.0 3.5)))
(assert (= (sqrt 42.0) (fpsqrt 42.0)))
(assert (= 43.0 (fpround 42.5)))
(assert (= -43.0 (fpround -42.5)))
(assert (= 42.0 (fpround 42.2)))
(assert (= 42.0 (fptruncate 42.5)))
(assert (= -42.0 (fptruncate -42.5)))
(assert (= 42.0 (fpfloor 42.2)))
(assert (= -43.0 (fpfloor -42.5)))
(assert (= 43.0 (fpceiling 42.5)))
(assert (= -42.0 (fpceiling -42.2)))
(assert (not (fpinteger? 2.3)))
(assert (fpinteger? 1.0))

;; string->symbol

;; by Jim Ursetto
(assert 
 (eq? '|3|
      (with-input-from-string
	  (with-output-to-string
	    (lambda ()
	      (write (string->symbol "3"))))
	read)))


;;; escaped symbol syntax

(assert (string=? "abc" (symbol->string '|abc|)))
(assert (string=? "abcdef" (symbol->string '|abc||def|)))
(assert (string=? "abcxyzdef" (symbol->string '|abc|xyz|def|)))
(assert (string=? "abc|def" (symbol->string '|abc\|def|)))
(assert (string=? "abc|def" (symbol->string '|abc\|def|)))
(assert (string=? "abc" (symbol->string '|abc:|))) ; keyword
(assert (string=? "abc" (symbol->string '|abc|:))) ; keyword
(assert (string=? ":abc" (symbol->string ':|abc|)))
(assert (string=? ":abc" (symbol->string '|:abc|)))
(assert (string=? "abc" (symbol->string 'abc)))
(assert (string=? "a c" (symbol->string 'a\ c)))
(assert (string=? "aBc" (symbol->string 'aBc)))

(parameterize ((case-sensitive #f))
  (assert (string=? "abc" (symbol->string (with-input-from-string "aBc" read))))
  (assert (string=? "aBc" (symbol->string (with-input-from-string "|aBc|" read))))
  (assert (string=? "aBc" (symbol->string (with-input-from-string "a\\Bc" read)))))


;;; setters

(define x '(a b c))
(define kar car)
(set! (kar (cdr x)) 99)
(assert (equal? '(a 99 c) x))
(define p (make-parameter 100))
(assert (= 100 (p)))
(set! (p) 1000)
(assert (= 1000 (p)))


;;; blob-literal syntax

(assert (equal? '#${a} '#${0a}))
(assert (equal? '#${ab cd} '#${abcd}))
(assert (equal? '#${ab c} '#${ab0c}))
(assert (equal? '#${abc} '#${ab0c}))
(assert (equal? '#${a b c} '#${0a0b0c}))


;;; getter-with-setter

(define foo
  (let ((m 2))
    (getter-with-setter
     (lambda (x) (* x m))
     (lambda (x) 
       (set! m x)))))

(assert (= 6 (foo 3)))
(set! (foo) 4)
(assert (= 20 (foo 5)))

(define bar
  (getter-with-setter
   foo
   (lambda (x)
     (+ x 99))))

(assert (= 12 (bar 3)))
(assert (= 100 (set! (bar) 1)))
(assert (= 12 (foo 3)))


;;; equal=?

(assert (not (equal=? 1 2)))
(assert (equal=? 1 1))
(assert (equal=? 1 1.0))
(assert (not (equal=? 1 1.2)))
(assert (equal=? 1.0 1))
(assert (equal=? '#(1) '#(1.0)))
(assert (not (equal=? 'a "a")))
(assert (equal=? "abc" "abc"))
(assert (equal=? '(1 2.0 3) '(1 2 3)))
(assert (equal=? '#(1 2.0 3) '#(1 2 3)))
(assert (equal=? '#(1 2 (3)) '#(1 2 (3))))
(assert (not (equal=? '#(1 2 (4)) '#(1 2 (3)))))
(assert (not (equal=? 123 '(123))))
