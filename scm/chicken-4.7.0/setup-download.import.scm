;;;; setup-download.import.scm - GENERATED BY CHICKEN 4.6.7 -*- Scheme -*-

(eval '(import
         scheme
         chicken
         foreign
         extras
         irregex
         posix
         utils
         srfi-1
         data-structures
         tcp
         srfi-13
         files
         setup-api))
(##sys#register-compiled-module
  'setup-download
  (list)
  '((retrieve-extension . setup-download#retrieve-extension)
    (locate-egg/local . setup-download#locate-egg/local)
    (locate-egg/svn . setup-download#locate-egg/svn)
    (locate-egg/http . setup-download#locate-egg/http)
    (gather-egg-information . setup-download#gather-egg-information)
    (list-extensions . setup-download#list-extensions)
    (list-extension-versions . setup-download#list-extension-versions)
    (temporary-directory . setup-download#temporary-directory))
  (list)
  (list))

;; END OF FILE
