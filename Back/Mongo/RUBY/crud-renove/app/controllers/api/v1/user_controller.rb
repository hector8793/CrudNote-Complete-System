class Api::V1::UserController < ApplicationController
    def index
        #render 'new'
        @user = User.all
        render json: @user
    end
    
    def show
        @user = User.find(params[:id])
        render json: @user
    end
    
    def create
        @user = User.new(user_params)
        @user.save
    end
    
    def update
        @user = User.find(params[:id])
        @user.update_attributes(user_params)
        render 'edit'
    end

    def destroy
        @user = User.find(params[:id])
        @user.destroy
        render 'delete'
    end

    private
    def user_params
        params.require(:user).permit(:name, :email, :pwd)
    end
end
