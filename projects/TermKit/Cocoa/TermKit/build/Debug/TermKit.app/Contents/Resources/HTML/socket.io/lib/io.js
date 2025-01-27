
/**
 * socket.io
 * Copyright(c) 2011 LearnBoost <dev@learnboost.com>
 * MIT Licensed
 */

(function (exports) {

  /**
   * IO namespace.
   *
   * @namespace
   */

  var io = exports;

  /**
   * Socket.IO version
   *
   * @api public
   */

  io.version = '0.7.3';

  /**
   * Protocol implemented.
   *
   * @api public
   */

  io.protocol = 1;

  /**
   * Available transports, these will be populated with the available transports
   *
   * @api public
   */

  io.transports = [];

  /**
   * Keep track of jsonp callbacks.
   *
   * @api private
   */

  io.j = [];

  /**
   * Keep track of our io.Sockets
   *
   * @api private
   */
  io.sockets = {};

  // if node

  /**
   * Expose constructors if in Node
   */

  if ('object' === typeof module && 'function' === typeof require) {

    /**
     * Expose utils
     *
     * @api private
     */

    io.util = require('./util').util;

    /**
     * Expose JSON.
     *
     * @api private
     */

    io.JSON = require('./json').JSON;

    /**
     * Expose parser.
     *
     * @api private
     */

    io.parser = require('./parser').parser;

    /**
     * Expose EventEmitter
     *
     * @api private
     */

    io.EventEmitter = process.EventEmitter;

    /**
     * Expose Transport
     *
     * @api public
     */

    io.Transport = require('./transport').Transport;

    /**
     * Expose all transports
     */

    io.transports.forEach(function (t) {
      //io.Transport[t] = require('./transports/node/' + t);
    });

    /**
     * Expose Socket
     *
     * @api public
     */

    io.Socket = require('./socket').Socket;

    /**
     * Location of `dist/` directory.
     *
     * @api private
     */

    io.dist = __dirname + '/../dist';

    /**
     * Expose our build system which can generate
     * socket.io files on the fly with different transports
     *
     * @api private
     */

    io.builder = require('../bin/builder');

  }
  // end node

  /**
   * Manages connections to hosts.
   *
   * @param {String} uri
   * @Param {Boolean} force creation of new socket (defaults to false)
   * @api public
   */

  io.connect = function (host, details) {
    var uri = io.util.parseUri(host)
      , uuri
      , socket;

    if ('undefined' != typeof document) {
      uri.protocol = uri.protocol || document.location.protocol.slice(0, -1);
      uri.host = uri.host || document.domain;
      uri.port = uri.port || document.location.port;
    }

    uuri = io.util.uniqueUri(uri);

    var options = {
        host: uri.host
      , secure: uri.protocol == 'https'
      , port: uri.port || 80
    };
    io.util.merge(options, details);

    if (options['force new connection'] || !io.sockets[uuri]) {
      socket = new io.Socket(options);
    }

    if (!options['force new connection'] && socket) {
      io.sockets[uuri] = socket;
    }

    socket = socket || io.sockets[uuri];

    // if path is different from '' or /
    return socket.of(uri.path.length > 1 ? uri.path : '');
  };

})('object' === typeof module ? module.exports : (window.io = {}));
