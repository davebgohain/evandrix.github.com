#
#   Copyright 2011 Wade Alcorn wade@bindshell.net
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.
#
module BeEF
module Extension
module Demos
  
  module RegisterHttpHandlers
    
    extend BeEF::API::Server::Handler
    
    def self.mount_handlers(beef_server)
      # mount the handler to support the demos
      dir = File.dirname(__FILE__)+'/html/'
      
      beef_server.mount('/demos/', true, WEBrick::HTTPServlet::FileHandler, dir)
    end
    
  end

end
end
end