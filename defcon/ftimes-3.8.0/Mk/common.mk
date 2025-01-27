######################################################################
#
# $Id: common.mk.in,v 1.4 2007/02/23 00:39:00 mavrik Exp $
#
######################################################################
#
# Purpose: Common Makefile macros.
#
######################################################################

CC=gcc

FTIMES=${PROJECT_ROOT}/src/ftimes

FTIMES_CRV2RAW=${PROJECT_TOPDIR}/tools/dig/ftimes-crv2raw.pl

TARMAP=${PROJECT_ROOT}/tools/tarmap/tarmap

TEST_HARNESS=${PROJECT_TOPDIR}/utils/test_harness

PROJECT_DEFAULT_INSTALL_ROOT=/usr/local/ftimes

SUBDIR_MAKE=cd $${cwd}/$${subdir} && ${MAKE} $@

SUBDIR_TRACE=echo "===> $${subdir}"

TARGET_MAKE=cd $${cwd}/$${target} && ${MAKE} $@

TARGET_TRACE=echo "---> $${target}"

