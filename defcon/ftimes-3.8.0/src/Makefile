
PROJECT_ROOT=..

PREFIX=/usr/local/ftimes

SRCDIR=.

VPATH=${SRCDIR}

INSTALL=/opt/local/bin/ginstall -c

INSTALL_PREFIX=${PREFIX}/bin

EXTENSION=

AP_INCS=
AP_SRCS=
AP_OBJS=${AP_SRCS:.c=.o}

PCRE_INCFLAGS=-I/opt/local/include
PCRE_LIBFLAGS=-L/opt/local/lib -lpcre

PCRE_INCS=
PCRE_SRCS=
PCRE_OBJS=${PCRE_SRCS:.c=.o}

SSL_INCFLAGS=-I/usr/include
SSL_LIBFLAGS=-L/usr/lib -lssl -lcrypto

SSL_INCS=ssl.h ssl-pool.h
SSL_SRCS=ssl.c
SSL_OBJS=${SSL_SRCS:.c=.o}

XMAGIC_INCS=
XMAGIC_SRCS=
XMAGIC_OBJS=${XMAGIC_SRCS:.c=.o}

INCS=\
all-includes.h\
${AP_INCS}\
app-includes.h\
compare.h\
config.h\
decode.h\
dig.h\
error.h\
fsinfo.h\
ftimes.h\
http.h\
ktypes.h\
mask.h\
md5.h\
message.h\
${PCRE_INCS}\
sha1.h\
sha256.h\
socket.h\
${SSL_INCS}\
sys-includes.h\
${XMAGIC_INCS}

SRCS=\
analyze.c\
${AP_SRCS}\
cfgtest.c\
cmpmode.c\
compare.c\
decode.c\
decoder.c\
develop.c\
dig.c\
digmode.c\
error.c\
fsinfo.c\
ftimes.c\
getmode.c\
http.c\
map.c\
mapmode.c\
mask.c\
md5.c\
message.c\
${PCRE_SRCS}\
properties.c\
sha1.c\
sha256.c\
socket.c\
${SSL_SRCS}\
support.c\
time.c\
url.c\
${XMAGIC_SRCS}

OBJS=${SRCS:.c=.o}

INCFLAGS=-I. ${PCRE_INCFLAGS} ${SSL_INCFLAGS}

LIBFLAGS=-lm  ${PCRE_LIBFLAGS} ${SSL_LIBFLAGS}

CFLAGS= -Wall -DUNIX -DHAVE_CONFIG_H

TARGET=ftimes${EXTENSION}

include ${PROJECT_ROOT}/Mk/common-src-c.mk

